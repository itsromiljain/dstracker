package com.tracker.admin.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

    public void importDemandFile(MultipartFile file);

    public void importSupplyFile(MultipartFile file);
}
