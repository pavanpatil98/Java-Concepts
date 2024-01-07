##basic commands
git init(Initialize git repo)
git status(No file added to staging area)
git add -A
git add .
git status (Added to staging area)
git commit -m "Initial java commit"(Commited changes in local repository)
git log
git branch dev(Creating branch -> branch commit not visible to any branches unless they are merged its for new feature development & end merge iwith parent)
git checkout dev(Switch to branch dev)
git -b checkout dev (Creates & checkout to that branch.)
##Pushing changes to remote repo.
git remote add origin https://github.com/pavanpatil98/Java-Concepts.git
git branch -M master
git push -u origin master
 
