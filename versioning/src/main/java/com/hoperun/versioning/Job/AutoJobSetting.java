package com.hoperun.versioning.Job;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

/**
 * Created by yuan_chen1 on 2016/5/12.
 */
public class AutoJobSetting {

    //通过SchedulerFactory来获取一个调度器
    public static SchedulerFactory sf = new StdSchedulerFactory();
    public static Scheduler scheduler = null;

    public static void jobStart(Date startTime,int executInterval,int executCount ){
        try {
            scheduler = sf.getScheduler();
            //引进作业程序
            JobDetailImpl jobDetail = new JobDetailImpl();
            jobDetail.setName("job1");
            jobDetail.setJobClass(AutoJobExecute.class);
            //new一个触发器
            SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
            simpleTrigger.setName("trigger1");
            //设置作业启动时间
            simpleTrigger.setStartTime(startTime);
            //设置作业执行间隔
            simpleTrigger.setRepeatInterval(executInterval);
            //设置作业执行次数
            simpleTrigger.setRepeatCount(executCount);
            //设置作业执行次数(不限次数)
            //simpleTrigger.setRepeatCount(-1);
            //作业和触发器设置到调度器中
            scheduler.scheduleJob(jobDetail, simpleTrigger);
            //启动调度器
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
