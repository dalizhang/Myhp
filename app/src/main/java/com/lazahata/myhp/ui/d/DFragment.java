package com.lazahata.myhp.ui.d;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentDBinding;
import com.lazahata.myhp.entity.Author;
import com.lazahata.myhp.entity.Thread;
import com.lazahata.myhp.model.HipdaModel;
import com.lazahata.myhp.ui.Tip;
import com.lazahata.myhp.ui.common.BaseVPFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class DFragment extends BaseVPFragment {

    private FragmentDBinding binding;
    private DAdapter dAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_d, container, false);
        List<Thread> threads = new ArrayList<>();
        dAdapter = new DAdapter(threads, new Callback() {
            @Override
            public void onClick(Thread thread) {
                Tip.toastShort(thread.getTitle());
            }
        });
        binding.list.setAdapter(dAdapter);
        loadThreadsFromServer();
        return binding.getRoot();
    }

    private void loadThreadsFromServer() {
        HipdaModel.getInstance().getForumDiscovery(new HipdaModel.ForumDiscoveryCallback() {
            @Override
            public void success(String result) {
                Observable.just(result).map(new Func1<String, List<Thread>>() {
                    @Override
                    public List<Thread> call(String s) {
                        return parseThreads(s);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<Thread>>() {
                    @Override
                    public void call(List<Thread> threads) {
                        if (null != dAdapter) {
                            dAdapter.setData(threads);
                            dAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }

            @Override
            public void failure(String msg) {
                Tip.toastLong(msg);
            }
        });
    }

    private List<Thread> parseThreads(String s) {
        List<Thread> threads = new ArrayList<>(50);
        for (Element element : Jsoup.parse(s).getElementById("threadlist").getElementById("moderate").getElementsByClass("datatable").first().getElementsByTag("tbody")) {
            Thread t = new Thread();
            try {
                Element title = element.getElementsByAttributeValueContaining("class", "subject ").first().getElementsByAttributeValueMatching("id", "thread_").first().getElementsByAttribute("href").first();
                t.setTitle(title.text());
                t.setHref(title.attr("href"));
                Element author = element.getElementsByAttributeValueMatching("class", "author").first().getElementsByAttribute("href").first();
                Author a = new Author();
                a.setHref(author.attr("href"));
                a.setName(author.text());
                t.setAuthor(a);
                t.setCreatedTime(element.getElementsByAttributeValueMatching("class", "author").first().children().last().text());
                t.setLastReplyTime(element.getElementsByAttributeValueMatching("class", "lastpost").first().children().last().child(0).text());

                threads.add(t);
            } catch (NullPointerException e) {
                // do nothing
            }
        }
        return threads;
    }

    @Override
    protected void onRealResume() {

    }

    @Override
    protected void onRealPause() {

    }
}
