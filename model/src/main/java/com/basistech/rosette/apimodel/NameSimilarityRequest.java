/*
* Copyright 2014 Basis Technology Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.basistech.rosette.apimodel;

import javax.validation.constraints.NotNull;

/**
 * Request object for name-similarity.
 *
 * This class carries the two names to compare.
 */
public final class NameSimilarityRequest extends Request {

    @NotNull
    private Name name1;
    @NotNull
    private Name name2;

    /**
     * Constructor for {@code NameMatchingRequest}
     * @param name1 First name to be matched against second name
     * @param name2 Second name to be matched against first name
     */
    public NameSimilarityRequest(Name name1,
                                 Name name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    /**
     * Gets the first name
     * @return first name
     */
    public Name getName1() {
        return name1;
    }

    /**
     * Gets the second name
     * @return second name
     */
    public Name getName2() {
        return name2;
    }

    /**
     * Sets the first name
     * @param name the name object.
     */
    public void setName1(Name name) {
        name1 = name;
    }

    /**
     * Sets the second name
     * @param name the name object.
     */
    public void setName2(Name name) {
        name1 = name;
    }

    @Override
    public int hashCode() {
        int result = name1 != null ? name1.hashCode() : 0;
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        return result;
    }

    /**
     * if the param is a {@code NameMatchingRequest}, compare contents for equality
     * @param o the object
     * @return whether or not the param object is equal to this object
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NameSimilarityRequest)) {
            return false;
        }

        NameSimilarityRequest that = (NameSimilarityRequest) o;
        return name1 != null ? name1.equals(that.getName1()) : that.name1 == null
                && name2 != null ? name2.equals(that.getName1()) : that.name2 == null;
    }
}
