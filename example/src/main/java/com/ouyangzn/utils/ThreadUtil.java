/*
 * 版权所有 (C) 2001-2015 深圳市艾派应用系统有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、Jul 8, 2015，ouyangzn创建。 
 */
package com.ouyangzn.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程工具类
 *
 * @author ouyangzn
 */
public class ThreadUtil {

  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int KEEP_ALIVE = 30;

  private static ExecutorService service =
      new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS,
          new LinkedBlockingQueue<Runnable>(CORE_POOL_SIZE * 5));

  /**
   * 在线程池中运行一个runnable
   *
   * @param r
   */
  public static void execute(Runnable r) {
    service.execute(r);
  }

  /**
   * 休眠一段时间
   *
   * @param time 单位:毫秒
   */
  public static void sleep(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
    }
  }
}
