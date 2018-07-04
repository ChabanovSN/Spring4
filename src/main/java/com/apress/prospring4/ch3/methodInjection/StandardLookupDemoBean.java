package com.apress.prospring4.ch3.methodInjection;

public class StandardLookupDemoBean implements DemoBean {
  private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    @Override
    public void someOperation() {
            myHelper.doSomethigHelpful();
    }
}
