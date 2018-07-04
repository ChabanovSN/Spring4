package com.apress.prospring4.ch4.groovy

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def ctx = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(ctx)

reader.beans {
    contacts(Contact, firstName:'Sergey',lastName: 'Chab', age: 36)
}
ctx.refresh()
println ctx.getBean("contacts")
