package com.diyo.app.authApp.repository;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.profile.path.AwsDirectoryBasePathProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminGetUserRequest;
import com.diyo.app.authApp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

}
