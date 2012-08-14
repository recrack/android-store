/*
 * Copyright (C) 2012 Soomla Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soomla.store.data;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

@RunWith(RobolectricTestRunner.class)
public class VirtualCurrencyStorageTest{

    private VirtualCurrencyStorage mStorage;

    @Before
    public void setUp() {
        mStorage = new VirtualCurrencyStorage(new FileStorage(Robolectric.application.getApplicationContext(),
                "soomla.virtualcurrency.test"));

//        System.out.println(Robolectric.application.getApplicationContext().getFilesDir());
    }

    @Test
    public void testAdd(){
        mStorage.add(10);
        Assert.assertEquals(mStorage.getBalance(), 10);
    }

    @Test
    public void testRemove(){
        mStorage.remove(2);
        Assert.assertEquals(mStorage.getBalance(), 0);
    }

    @Test
    public void testAddRemove(){
        mStorage.add(10);
        mStorage.remove(2);
        Assert.assertEquals(mStorage.getBalance(), 8);
    }
}