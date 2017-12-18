package com.wdtpr.augus.debugnetexample.Pet.model.bean.out;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class outPermission implements Serializable {

    private Permission.ResultObject.ProviderPermission provider_permission;
    private Permission.ResultObject.AssistantPermission assistant_permission;

    public Permission.ResultObject.ProviderPermission getProvider_permission() {
        return provider_permission;
    }

    public void setProvider_permission(Permission.ResultObject.ProviderPermission provider_permission) {
        this.provider_permission = provider_permission;
    }

    public Permission.ResultObject.AssistantPermission getAssistant_permission() {
        return assistant_permission;
    }

    public void setAssistant_permission(Permission.ResultObject.AssistantPermission assistant_permission) {
        this.assistant_permission = assistant_permission;
    }
}
