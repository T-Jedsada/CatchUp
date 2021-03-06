/*
 * Copyright (c) 2018 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  id("kotlin-noarg")
}

apply {
  from(rootProject.file("gradle/config-kotlin-sources.gradle"))
}

noArg {
  annotation("io.sweers.catchup.service.hackernews.model.NoArg")
}

dependencies {
  api(project(":service-api"))
  implementation(project(":libraries:util"))

  kapt(project(":service-registry:service-registry-compiler"))
  kapt(deps.crumb.compiler)
  kapt(deps.dagger.apt.compiler)
  kapt(deps.assistedInject.processor)
  compileOnly(deps.assistedInject.annotations)

  implementation(deps.android.androidx.swipeRefresh)
  implementation(deps.android.androidx.viewModel.core)
  implementation(deps.android.androidx.viewModel.ktx)
  implementation(deps.android.androidx.viewModel.savedState)
  implementation(deps.android.firebase.database)

  api(deps.android.androidx.design)
  api(deps.android.androidx.fragmentKtx)
  api(deps.android.androidx.annotations)
  api(deps.dagger.runtime)
  api(deps.rx.java)
}
