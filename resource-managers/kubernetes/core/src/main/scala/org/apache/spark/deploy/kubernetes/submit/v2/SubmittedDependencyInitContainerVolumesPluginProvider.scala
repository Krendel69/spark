/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.spark.deploy.kubernetes.submit.v2

import io.fabric8.kubernetes.api.model.Secret

import org.apache.spark.deploy.kubernetes.constants._

private[spark] trait SubmittedDependencyInitContainerVolumesPluginProvider {
  def getInitContainerVolumesPlugin(
      initContainerSecret: Secret): SubmittedDependencyInitContainerVolumesPlugin
}

private[spark] class SubmittedDependencyInitContainerVolumesPluginProviderImpl
    extends SubmittedDependencyInitContainerVolumesPluginProvider {
  override def getInitContainerVolumesPlugin(
      initContainerSecret: Secret): SubmittedDependencyInitContainerVolumesPlugin = {
    new SubmittedDependencyInitContainerVolumesPluginImpl(
      initContainerSecret, INIT_CONTAINER_SECRET_VOLUME_MOUNT_PATH)
  }
}
