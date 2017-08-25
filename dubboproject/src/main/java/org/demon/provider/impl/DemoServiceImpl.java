package org.demon.provider.impl;

import org.demon.api.DemoService;

public class DemoServiceImpl  implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}