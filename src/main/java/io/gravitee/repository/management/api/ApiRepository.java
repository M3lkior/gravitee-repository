/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.repository.management.api;

import io.gravitee.repository.exceptions.TechnicalException;
import io.gravitee.repository.management.model.Api;
import io.gravitee.repository.management.model.Visibility;
import io.gravitee.repository.management.model.Membership;
import io.gravitee.repository.management.model.MembershipType;

import java.util.Collection;
import java.util.Set;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public interface ApiRepository extends CrudRepository<Api, String>{

    /**
     * List all APIs.
     *
     * @return All APIs.
     */
    Set<Api> findAll() throws TechnicalException;

    /**
     * List APIs for a given user and a given membership type.
     *
     * @param username The name of the user.
     * @param membershipType API membership type filter.
     * @return List APIs from a user.
     */
    Set<Api> findByMember(String username, MembershipType membershipType, Visibility visibility) throws TechnicalException;

    /**
     * Count all APIs for a given user and a given membership type.
     *
     * @param username owner user name
     * @param membershipType API membership type filter.
     * @return counted APIs
     */
    int countByUser(String username, MembershipType membershipType) throws TechnicalException;

    /**
     * Find APIs associated with an application
     *
     * @param applicationId Application ID
     * @return Apis associated
     */
    Set<Api> findByApplication(String applicationId) throws TechnicalException;

    void saveMember(String apiId, String username, MembershipType membershipType) throws TechnicalException;

    void deleteMember(String apiId, String username) throws TechnicalException;

    Collection<Membership> getMembers(String apiId, MembershipType membershipType) throws TechnicalException;

    Membership getMember(String apiId, String username) throws TechnicalException;
}