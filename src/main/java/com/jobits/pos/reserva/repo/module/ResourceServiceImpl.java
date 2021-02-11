/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.module;

import com.root101.clean.core.domain.services.ResourceService;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.domain.services.ResourceBundleUtils;
import com.root101.clean.core.domain.services.DefaultResourceBundleService;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class ResourceServiceImpl implements ResourceService {

    private final DefaultResourceBundleService resourceService;
    public static final String RESOURCE_URL = "module";

    public ResourceServiceImpl() {
        resourceService = new DefaultResourceBundleService(
                ResourceBundleUtils.fromInternalFile(RESOURCE_URL,
                        ResourceBundleUtils.SPANISH));
        ResourceHandler.registerResourceService(this);
    }

    @Override
    public String getString(String string) {
        return resourceService.getString(string);
    }

    @Override
    public Object getObject(String string) {
        return resourceService.getObject(string);
    }

    @Override
    public boolean contain(String string) {
        return resourceService.contain(string);
    }

}
