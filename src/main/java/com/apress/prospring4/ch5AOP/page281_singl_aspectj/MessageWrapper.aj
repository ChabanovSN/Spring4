package com.apress.prospring4.ch5AOP.page281_singl_aspectj;

 public aspect MessageWrapper{
     String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPrefix() {
        return prefix;
    }
    pointcut doWriting():
            execution(* com.apress.prospring4.ch5AOP.page281_singl_aspectj.MessageWriter.writeMessage());

    before(): doWriting(){
        System.out.println(prefix);
    }
    after(): doWriting(){
        System.out.println(suffix);
    }

}