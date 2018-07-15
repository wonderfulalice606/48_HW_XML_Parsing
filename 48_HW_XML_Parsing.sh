#!/bin/sh

#===========================================================================================
GITHUB=wonderfulalice606
WS_DIR=workspace
DOC=Documents
REPO=48_HW_XML_Parsing
RUNNER=Test_Runner

#===========================================================================================

if ! which java > /dev/null 2>&1; then echo Java is not installed; return; fi
if ! which mvn > /dev/null 2>&1; then echo Maven is not installed; return; fi
if ! which git > /dev/null 2>&1; then echo Git is not installed; return; fi

if [ -d "$HOME/$DOC/$WS_DIR/" ]; then cd ~/$DOC/$WS_DIR/$RUNNER; else echo $WS_DIR is not exist; return; fi
if [ -d "$HOME/$DOC/$WS_DIR/$RUNNER/$REPO" ]; then rm -rf $HOME/$DOC/$WS_DIR/$RUNNER/$REPO; fi

git clone https://github.com/$GITHUB/$REPO.git
cd ./$REPO

mvn package -Dbuild.version="1.1" -Dmain.Class="core.DOM_Parser"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.2" -Dmain.Class="core.DOM_XPath_Parser"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.3" -Dmain.Class="core.SAX_Parser"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.4" -Dmain.Class="core.StAX_Parser"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.5" -Dmain.Class="core.DOM_Parser_WS"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.6" -Dmain.Class="core.DOM_XPath_Parser_WS"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.7" -Dmain.Class="core.SAX_Parser_WS"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar

mvn package -Dbuild.version="1.8" -Dmain.Class="core.Stax_Parser_WS"

java -jar ./target/48_HW_XML_Parsing-1.0-jar-with-dependencies.jar


echo "$HOME/$DOC/$WS_DIR/$RUNNER/$REPO"
