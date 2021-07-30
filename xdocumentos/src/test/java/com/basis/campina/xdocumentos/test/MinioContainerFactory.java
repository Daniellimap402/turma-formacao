package com.basis.campina.xdocumentos.test;

import org.testcontainers.containers.GenericContainer;

public class MinioContainerFactory {
    private static GenericContainer container;

    public static GenericContainer getInstance() {
        if (container == null) {
            container = new GenericContainer("minio/minio").withExposedPorts(
                            9000)
                    .withEnv("MINIO_ACCESS_KEY", "accesskey").withEnv("MINIO_SECRET_KEY", "secretkey")
                    .withCommand("server /data");
            container.start();
            System.setProperty("MINIO_URL", "http://" + container.getHost() + ":" + container.getMappedPort(9000));
        }
        return container;
    }

}
