# MakefileによるJavaFXアプリケーションのビルド
# 注意点
# (1) fxmlからのみ呼び出されるFXML**Controller.javaは、
# 　　メインアプリケーションに直接依存しないため、
# 　　javacでビルドする際にビルド対象として指示する必要がある。
# (2) fxmlはクラスパスで参照されるため、クラスパス側にコピーしておく必要がある。
# (3) JavaFX9以降は、実行時に--module-pathと--add-modulesでJavaFXを指示する必要がある。（未検証）

CLS_PATH = build/classes
SRC_PATH = src

PKG_CLIENT = echoclient
TGT_CLIENT = $(PKG_CLIENT).EchoClient

PKG_SERVER = echoserver
TGT_SERVER = $(PKG_SERVER).EchoServer

PKG_CLIENT_PATH = $(subst .,/,$(PKG_CLIENT))
TGT_CLIENT_PATH = $(subst .,/,$(TGT_CLIENT))
PKG_SERVER_PATH = $(subst .,/,$(PKG_SERVER))
TGT_SERVER_PATH = $(subst .,/,$(TGT_SERVER))

SRC_CLIENT = $(SRC_PATH)/$(TGT_CLIENT_PATH).java \
             $(SRC_PATH)/$(PKG_CLIENT_PATH)/FXMLClientController.java

SRC_SERVER = $(SRC_PATH)/$(TGT_SERVER_PATH).java \
             $(SRC_PATH)/$(PKG_SERVER_PATH)/FXMLServerController.java

all:build_server build_client

client:build_client
	java -classpath $(CLS_PATH) $(TGT_CLIENT)

server:build_server
	java -classpath $(CLS_PATH) $(TGT_SERVER)

build_client:
	mkdir -p $(CLS_PATH)
	javac -sourcepath $(SRC_PATH) $(SRC_CLIENT) -d $(CLS_PATH)
	rsync -av --include="*/" --include="*.fxml" --exclude="*" $(SRC_PATH)/ $(CLS_PATH)

build_server:
	mkdir -p $(CLS_PATH)
	javac -sourcepath $(SRC_PATH) $(SRC_SERVER) -d $(CLS_PATH)
	rsync -av --include="*/" --include="*.fxml" --exclude="*" $(SRC_PATH)/ $(CLS_PATH)

clean:
	rm -rf build/
	find . -type f -name "*.class" | xargs rm -rf