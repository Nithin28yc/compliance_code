def call(Map params) 
{
   stage("Data at Rest&Transit - SSLLabs")
   {
   
      container('maven') {
	
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
        mvn test -DSSLURL="https://qemainlatest.continuoustestplatform.com/" -DsuiteXmlFile=SSL_testng.xml
   
	'''
		  withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html SSLLabs.html
				  curl --upload-file SSLLabs.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
				  '''
				}
	}
						
        
    }
}

