package me.tode.cloud.democlient.service;

public interface ClientService {
    String productMessage();

    String readingList();

    String productMessageByLoadBalancer();

    default String productMessageDefault() {
        return "message produced by the default method defined in the interface";
    }
}
