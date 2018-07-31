package org.nankong.igniteweb.dao.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.nankong.igniteweb.model.OrgInfo;

@RepositoryConfig(cacheName="orgCache")
public interface OrgInfoRepository extends IgniteRepository<OrgInfo,String> {
    OrgInfo queryAllByOrgCode(String orgCode);
}
