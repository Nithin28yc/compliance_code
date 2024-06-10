def call(Map params) 
{
   stage("Password Management-Password History Policy")
   {
    
      container('maven') {
	
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
  	mvn test -DappURL="https://qemainlatest.continuoustestplatform.com/" -Dusername="ethanadmin" -Dpassword="D8SYqKRmcC4dn8Am38" -Dldapuname="nonAdmin" -DldapEmail="nonadmin@gmail.com" -DldapPass="Test@1234" -DnewPassword="Test@5678" -DsuiteXmlFile=PasswordHistoryPolicy.xml
	
	'''
		  withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html PasswordHistoryPolicy.html
				  curl --upload-file PasswordHistoryPolicy.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
				  '''
				}
	}
						
        
    }
}

