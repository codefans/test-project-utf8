package com.codefans.reusablecode.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: codefans
 * @date: 2019-07-26 16:00
 * 响应式编程
 *    Observer模式+异步处理
 *
 *    Observable是事件源
 *    ObservableEmitter弹出事件
 *
 *    被观察者（Observable）
 *    观察者（Observer）
 *    订阅（subscribe）
 *
 * 使用场景：
 *
 * 参考资料：
 *    RxJava2 只看这一篇文章就够了
 *    https://juejin.im/post/5b17560e6fb9a01e2862246f
 *
 */
public class HelloRxJava {

    public static void main(String[] args) {

        HelloRxJava helloRxJava = new HelloRxJava();
//        helloRxJava.rxWithConsumer();
//        helloRxJava.rxWithSubscribe();
        helloRxJava.rxWithLinkProgramming();

    }

    public void rxWithConsumer() {

        /**
         * Observable被观察者，也是事件源
         */
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>(){
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("11111");
                observableEmitter.onNext("22222");
                observableEmitter.onNext("33333");
                observableEmitter.onNext("44444");
            }
        });

        /**
         * 观察者
         */
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + ":" + s);
            }
        };

        /**
         * 在当前线程中运行
         */
//        observable.subscribe(consumer);
        /**
         * 异步线程执行
         */
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);

        this.sleepForAWhile(5);

    }

    /**
     * 比较复杂的观察者可以用Observer
     */
    public void rxWithSubscribe() {

        /**
         * 被观察者
         */
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>(){
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("aaa");
                observableEmitter.onNext("bbb");
                observableEmitter.onNext("ccc");
                observableEmitter.onNext("ddd");
            }
        });

        /**
         * 观察者
         */
        Observer<String> observer = new Observer<String>(){

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(Thread.currentThread().getName() + ":" + s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

//        observable.subscribe(observer);
        observable.observeOn(Schedulers.newThread()).subscribe(observer);

        this.sleepForAWhile(5);


    }

    /**
     * 链式编程的写法
     */
    public void rxWithLinkProgramming() {

        Observable.create(new ObservableOnSubscribe<String>(){
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("link programming event_01");
                observableEmitter.onNext("link programming event_02");
                observableEmitter.onNext("link programming event_03");
                observableEmitter.onNext("link programming event_04");
            }
//        }).subscribe(new Consumer<String>() {
        }).observeOn(Schedulers.newThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + ":" + s);
            }
        });

        this.sleepForAWhile(5);


    }


    public void sleepForAWhile(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
