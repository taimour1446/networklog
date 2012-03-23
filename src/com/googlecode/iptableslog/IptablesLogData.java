package com.googlecode.iptableslog;

import android.util.Log; 

import java.util.ArrayList;
import java.util.Hashtable;

public class IptablesLogData {
  /* ApplicationsTracker */
  ArrayList<ApplicationsTracker.AppEntry> applicationsTrackerInstalledApps;
  Hashtable<String, ApplicationsTracker.AppEntry> applicationsTrackerInstalledAppsHash;
  int applicationsTrackerAppCount;

  public void gatherApplicationsTrackerData() {
    applicationsTrackerInstalledApps = ApplicationsTracker.installedApps;
    applicationsTrackerInstalledAppsHash = ApplicationsTracker.installedAppsHash;
    applicationsTrackerAppCount = ApplicationsTracker.appCount;
  }

  /* LogView */
  ArrayList<LogView.ListItem> logViewListData;
  ArrayList<LogView.ListItem> logViewListDataBuffer;

  public void gatherLogViewData() {
    if(IptablesLog.logView != null) {
      logViewListData = IptablesLog.logView.listData;
      logViewListDataBuffer = IptablesLog.logView.listDataBuffer;
    }
  }

  /* AppView */
  ArrayList<AppView.ListItem> appViewListData;
  ArrayList<AppView.ListItem> appViewListDataBuffer;
  boolean appViewListDataBufferIsDirty;
  Sort appViewSortBy;
  Sort appViewPreSortBy;
  AppView.ListItem appViewCachedSearchItem;

  public void gatherAppViewData() {
    if(IptablesLog.appView != null) {
      appViewListData = IptablesLog.appView.listData;
      appViewListDataBuffer = IptablesLog.appView.listDataBuffer;
      appViewListDataBufferIsDirty = IptablesLog.appView.listDataBufferIsDirty;
      appViewSortBy = IptablesLog.appView.sortBy;
      appViewPreSortBy = IptablesLog.appView.preSortBy;
      appViewCachedSearchItem = IptablesLog.appView.cachedSearchItem;
    }
  }

  /* IptablesLogTracker */
  Hashtable<String, IptablesLogTracker.LogEntry> iptablesLogTrackerLogEntriesHash;
  StringBuilder iptablesLogTrackerBuffer;
  ShellCommand iptablesLogTrackerCommand;

  public void gatherIptablesLogTrackerData() {
    if(IptablesLog.logTracker != null) {
      iptablesLogTrackerLogEntriesHash = IptablesLog.logTracker.logEntriesHash;
      iptablesLogTrackerBuffer = IptablesLog.logTracker.buffer;
      iptablesLogTrackerCommand = IptablesLog.logTracker.command;
    }
  }

  /* IptablesLog */
  IptablesLog.State iptablesLogState;

  public void gatherIptablesLogData() {
    iptablesLogState = IptablesLog.state;
  }

  public IptablesLogData() {
    gatherApplicationsTrackerData();
    gatherLogViewData();
    gatherAppViewData();
    gatherIptablesLogTrackerData();
    gatherIptablesLogData();
  }
}
