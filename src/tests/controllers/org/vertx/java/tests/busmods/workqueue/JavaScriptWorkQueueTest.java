/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vertx.java.tests.busmods.workqueue;

import org.junit.Test;
import org.vertx.java.framework.TestBase;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class JavaScriptWorkQueueTest extends TestBase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();

  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  @Test
  public void testWorkQueue() throws Exception {
    startApp("busmods/workqueue/test_client.js");
    int numProcessors = 10;
    for (int i = 0; i < numProcessors; i++) {
      startApp(true, "busmods/workqueue/order_processor.js");
    }
    startTest(getMethodName());
  }

  @Test
  public void testPersistentWorkQueue() throws Exception {
    startApp("busmods/workqueue/persistent_test_client.js");
    int numProcessors = 10;
    for (int i = 0; i < numProcessors; i++) {
      startApp(true, "busmods/workqueue/order_processor.js");
    }
    startTest(getMethodName());
  }

  @Test
  public void testPersistentReloadWorkQueue() throws Exception {
    startApp("busmods/workqueue/persistent_reload_test_client.js");
    startTest(getMethodName());
  }


}
