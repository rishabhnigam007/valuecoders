package com.assetsmanagement.assets_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assetsmanagement.assets_management.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
}