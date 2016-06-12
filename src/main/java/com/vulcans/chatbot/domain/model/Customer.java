package com.vulcans.chatbot.domain.model;

import com.vulcans.chatbot.data.Context;
import com.vulcans.chatbot.runtime.ConversationLog;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String totalCredit;
    private String lastSentOTP;
    private String lastSentOTPTS;
    private Context currentContext;
    private ConversationLog conversationLog = new ConversationLog();

    public Customer(String customerId, String firstName, String lastName, String emailAddress, String amount,
                    String lastSentOTP, String lastSentOTPTS, Context context) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.totalCredit = amount;
        this.lastSentOTP = lastSentOTP;
        this.lastSentOTPTS = lastSentOTPTS;
        this.currentContext = context;
    }

    public String getLastSentOTP() {
        return lastSentOTP;
    }

    public String getLastSentOTPTS() {
        return lastSentOTPTS;
    }

    public String getTotalCredit() {
        return totalCredit;
    }

    public Context getCurrentContext() {
        return currentContext;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public ConversationLog getConversationLog() {
        return conversationLog;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", totalCredit='" + totalCredit + '\'' +
                ", lastSentOTP='" + lastSentOTP + '\'' +
                ", lastSentOTPTS='" + lastSentOTPTS + '\'' +
                ", currentContext=" + currentContext +
                ", conversationLog=" + conversationLog +
                '}';
    }
}
