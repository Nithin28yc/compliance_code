def call(Map params) 
{
   stage("Authentication/Authorisation-Role based permission")
   {
   
      container('maven') {
	
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
        mvn test -DappURL="https://qemainlatest.continuoustestplatform.com/" -Dusername="nithin" -Dpassword="Test@1234" -DsuiteXmlFile=RBAC_testng.xml
   
	'''
	
		  withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html RBAC.html
				  curl --upload-file RBAC.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
				  '''
				}
	}
						
        
    }
}

