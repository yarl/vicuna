# ![a](https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/VicunaUploader_logo.png/30px-VicunaUploader_logo.png) VicuñaUploader
_ultimate tool for upload files to Wikimedia Commons and other Wikimedia projects_

## Usage
For manual, take a look at [project wiki](https://github.com/yarl/vicuna/wiki) and [website](https://yarl.github.io/vicuna).

## Build and Run
Program is being written using any IDE (NetBeans preferred) you want and [Gradle](https://gradle.org/) is used for building. In order to download and build source code, do following:

```
git clone https://github.com/yarl/vicuna.git
cd vicuna
./gradlew build
```
You will find distribution tar and zip `build/distributions` directory.

```
cd build/distributions/
unzip cuploader.zip
./cuploader/bin/cuploader
```

If you want to just run local build:

```
./gradlew run
```

Create org-wikipedia-Wiki.jar file:
```
git clone https://github.com/MER-C/wiki-java.git
cd wiki-java
mkdir -p org-wikipedia-Wiki/org/wikipedia
cp src/org/wikipedia/Wiki.java org-wikipedia-Wiki/org/wikipedia/
javac org-wikipedia-Wiki/org/wikipedia/Wiki.java
cd org-wikipedia-Wiki
jar cfv org-wikipedia-Wiki-`git rev-parse --verify HEAD --short=6`.jar -C org-wikipedia-Wiki/ .
```

## Contribute
Feel free to fork and suggest changes. However, please do not send pull requests with radical changes without prior discussion. Also, changes should work on NetBeans (especially project building and Form Designer).

## License
```
Copyright 2015 Paweł Marynowski

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## Contributors
```
Florian Straub
Michal Josef Špaček
Nicolas Raoul
```

### External libs used

- [wiki-java](https://github.com/MER-C/wiki-java) (AGPLv3+ / GPLv3+)
- [metadata-extractor](https://github.com/drewnoakes/metadata-extractor) (Apache 2.0)
- [jxmapviewer2](https://github.com/msteiger/jxmapviewer2) (LGPL)
- IU icons by [Yusuke Kamiyamane](http://p.yusukekamiyamane.com/) (CC BY-3.0)
