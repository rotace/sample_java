# MakefileによるJavaFXアプリケーションのビルド
# 注意点
# (1) fxmlからのみ呼び出されるFXMLDocumentController.javaは、
# 　　メインアプリケーションに直接依存しないため、
# 　　javacでビルドする際にビルド対象として指示する必要がある。
# (2) fxmlはクラスパスで参照されるため、クラスパス側にコピーしておく必要がある。
# (3) JavaFX9以降は、実行時に--module-pathと--add-modulesでJavaFXを指示する必要がある。（未検証）


CLS_PATH = build
SRC_PATH = src

TGT = pkg.Sample
SRC = $(SRC_PATH)/pkg/Sample.java \
      $(SRC_PATH)/pkg/FXMLDocumentController.java


all:compile

run:compile
	java -classpath $(CLS_PATH) $(TGT)

compile:
	mkdir -p build
	javac -sourcepath $(SRC_PATH) $(SRC) -d $(CLS_PATH)
	rsync -av --include="*/" --include="*.fxml" --exclude="*" $(SRC_PATH)/ $(CLS_PATH)

clean:
	rm -rf build/
	find . -type f -name "*.class" | xargs rm -rf