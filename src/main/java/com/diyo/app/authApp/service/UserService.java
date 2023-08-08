package com.diyo.app.authApp.service;

import com.diyo.app.authApp.entity.User;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final String USER_POOL_ID = "us-east-1_bg1pyOzF";
    private final String CLIENT_ID = "907243637903";
    private final String REGION = "us-east-1";
    private CognitoIdentityProviderClient client;
    public UserService(){
        this.client = CognitoIdentityProviderClient.builder()
                .region(Region.of(REGION))
                .build();
    }
    public String validateUserLogin(User user) {
        Map<String, String> authParameters = new HashMap<>();
        authParameters.put("USERNAME", user.getUsername());
        authParameters.put("PASSWORD", user.getPassword());
        authParameters.put("USER_POOL_ID", USER_POOL_ID);

        InitiateAuthRequest request = InitiateAuthRequest.builder()
                .clientId(CLIENT_ID)
                .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .authParameters(authParameters)
                .build();

        InitiateAuthResponse response = client.initiateAuth(request);
        AuthenticationResultType authenticationResultType = response.authenticationResult();
        return authenticationResultType.idToken();
    }
    public String validateUserSignup(User user){
        if(user.getUsername().equals("sdfsdfs"))
            return "??";
        else
            return "You are the member in Diyo now";
    }
}
