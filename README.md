# ![a](https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/VicunaUploader_logo.png/30px-VicunaUploader_logo.png) VicuñaUploader
_ultimate tool for upload files to Wikimedia Commons and other Wikimedia projects_

## Usage
For manual, take a look at [project wiki](https://github.com/yarl/vicuna/wiki) and [website](http://yarl.github.io/vicuna). 

## Building

If you want to run progam from source code, build it using [Ant](https://ant.apache.org/). Type commands below in console:

```
ant package-for-store
java -jar store/vicuna.jar
```

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

### External libs used

- [wiki-java](http://code.google.com/p/wiki-java/) (GNU GPL)
- [metadata-extractor](https://github.com/drewnoakes/metadata-extractor) (Apache 2.0)
- [JMapViewer](https://github.com/msteiger/jxmapviewer2) (LGPL)
- IU icons by [Yusuke Kamiyamane](http://p.yusukekamiyamane.com/) (CC BB 3.0)
