rm -rf /Users/houningning/Documents/mywksp/git/MacOS-Master/macos-*   
cp -r /Users/houningning/Documents/mywksp/MacOS-Master/macos-* /Users/houningning/Documents/mywksp/git/MacOS-Master/
cp -r /Users/houningning/Documents/mywksp/MacOS-Master/eureka-server /Users/houningning/Documents/mywksp/git/MacOS-Master

git add .
git commit -m $1
git push -u origin master


