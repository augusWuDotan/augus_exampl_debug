package com.wdtpr.augus.ranking;


import io.reactivex.disposables.Disposable;

/**
 * Created by augus on 2017/12/2.
 */

public class DisposableManager {
    private static volatile DisposableManager disposableManager;
    private io.reactivex.disposables.CompositeDisposable compositeDisposable;

    private DisposableManager() {
        compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
    }

    public static DisposableManager instance() {
        if (disposableManager == null) {
            synchronized (DisposableManager.class) {
                if (disposableManager == null) {
                    disposableManager = new DisposableManager();
                }
            }
        }
        return disposableManager;
    }

    public void add(Disposable d) {
        compositeDisposable.add(d);
    }

    public void addAll(Disposable... ds) {
        compositeDisposable.addAll(ds);
    }

    public void clear() {
        compositeDisposable.clear();
    }

    public int size() {
        return compositeDisposable.size();
    }

    public void dispose() {
        compositeDisposable.dispose();
    }

    public boolean isDisposed() {
        return compositeDisposable.isDisposed();
    }

    public void delete(Disposable d) {
        compositeDisposable.delete(d);
    }

    public void remove(Disposable d) {
        compositeDisposable.delete(d);
    }
}
