# gradleの使い方をmakefileで整理した


OPTS = 
# OPTS = --daemon


help:
	# 利用できるタスク一覧
	gradle $(OPTS) tasks

compile:
	# apply plugin: 'java' で追加されるタスク
	gradle $(OPTS) compileJava

test:
	# apply plugin: 'java' で追加されるタスク
	gradle $(OPTS) test

run:
	# apply plugin: 'application' で追加されるタスク
	gradle $(OPTS) run

gui:
	# gradleのGUIモード
	gradle $(OPTS) --gui

start:
	# daemon起動（常駐により処理が早くなる）
	gradle --daemon

stop:
	# daemon終了
	gradle --stop