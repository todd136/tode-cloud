package me.tode.cloud.democlient.service;

public interface ClientService {
    String productMessage();

    default String productMessageDefault() {
        return "message produced by the default method defined in the interface";
    }
}
