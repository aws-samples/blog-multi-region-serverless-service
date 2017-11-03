package com.amazonaws.serverless.globalservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * Simple Java client for testing Hello World API.
 *
 */
public class JavaClient {

    public static void main(String [] args) {
        System.out.println("Simple Java test for calling Hello Word service");

        try {
            // Get the endpoint for Hello World API
            String endpoint = args[0];

            // Create the client and call the API
            Client client = Client.create();
            WebResource webResource = client
                    .resource(endpoint+"helloworld/");
            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            // Process the result
            if (response.getStatus() != 200) {
                throw new RuntimeException("Called failed to HelloWorld : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Response: ");
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
