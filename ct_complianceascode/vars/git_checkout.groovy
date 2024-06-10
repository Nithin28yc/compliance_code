def call(Map params) 
{
     def GIT_URL= 'https://innersource.accenture.com/scm/ethan/ct_complianceascode.git'
	 def GIT_CREDENTIAL_ID ='nithinyc'
     def GIT_BRANCH='nithinNew'
    stage("${params.repo} - git checkout")
    {
     sh 'ls -lart'
     //Cloning the code from repo
     
    	git branch: GIT_BRANCH, url: GIT_URL,credentialsId: GIT_CREDENTIAL_ID
		 sh '''
		 ls -lart
        	 '''
        
    }
}
