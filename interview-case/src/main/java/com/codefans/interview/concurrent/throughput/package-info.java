/**
 * 该包主要用于对比ExecutorService和CompletionService的吞吐量测试
 *
 * 测试条件：
 *    1、相同的线程池设置。
 *    2、提交相同的任务。基础任务5个，分别执行10ms、20ms、30ms、40ms、50ms，一共执行大约10秒。
 *
 * 测试数据：
 *     CompletionService, submitTask=104755, completedTaskCount=4513, total time cost:[10034ms], throughput=[451]qps
 *     ExecutorService, submitTask=100000, completedTaskCount=2125, total time cost:[10004ms], throughput=[212]qps
 *
 *     CompletionService, submitTask=104754, completedTaskCount=4498, total time cost:[10021ms], throughput=[449]qps
 *     ExecutorService, submitTask=100000, completedTaskCount=2129, total time cost:[10012ms], throughput=[212]qps
 *
 *     CompletionService, submitTask=104729, completedTaskCount=4476, total time cost:[10011ms], throughput=[447]qps
 *     ExecutorService, submitTask=100000, completedTaskCount=2124, total time cost:[10001ms], throughput=[212]qps
 *
 *     CompletionService, submitTask=104769, completedTaskCount=4506, total time cost:[10001ms], throughput=[450]qps
 *     ExecutorService, submitTask=100000, completedTaskCount=2119, total time cost:[10000ms], throughput=[211]qps
 *
 * 测试结论：
 *    CompletionService比ExecutorService有更高的吞吐量，CompletionService的吞吐量大约是ExecutorService的2倍。
 *
 * @Date 2021/10/18 18:32
 * @author codefans
 */
package com.codefans.interview.concurrent.throughput;