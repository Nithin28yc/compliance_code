def call(Map params) 
{
   stage("Notice- Cookie content Validation")
   {

      container('maven') {
	
      	withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'nithinyc',
        usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) 
     {
	sh'''
    	cd Compliance_Check
    	ls
    	pwd
    	# give the platform url with username and password
    	 mvn test -DappURL="https://mywizarddevops.accenture.com/" -DenterpriseID="nithin.y.c@accenture.com" -DenterprisePassword=$PASSWORD -DsuiteXmlFile=cookieValidation_testng.xml
	 '''
     }
	withCredentials([usernamePassword(credentialsId: 'NEXUS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
				  sh '''
				  cd "$PWD"/test-output
				  mv LatestTestReportchromereport.html CookieValidation.html
				  curl --upload-file CookieValidation.html -u $USERNAME:$PASSWORD -v https://qemainlatest.continuoustestplatform.com/nexus/repository/Compliance/${JOB_NAME}/$BUILD_ID/
				  sleep 30
                  '''
				}
	}
						
        
    }
}

