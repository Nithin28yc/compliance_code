def call(Map params) 
{
   stage("Password Management-Verify Password Encryption in active directory")
   {
   
      container('maven') {
	
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
        mvn test -DappURL="https://qemainlatest.continuoustestplatform.com/" -Dusername="ethanadmin" -Dpassword="D8SYqKRmcC4dn8Am38" -DsuiteXmlFile=VerifyPasswordEncryption.xml

	'''
		  withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html PasswordEncryption.html
				  curl --upload-file PasswordEncryption.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
				  '''
				}
	}
						
        
    }
}

