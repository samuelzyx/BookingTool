
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/"
grails.plugin.springsecurity.logout.filterProcessesUrl = '/api/logout'
grails.plugin.springsecurity.logout.postOnly = false

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.usernamePropertyName='email'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'bookingtool.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'bookingtool.UserRole'
grails.plugin.springsecurity.authority.className = 'bookingtool.Role'
grails.plugin.springsecurity.requestMap.className = 'bookingtool.Requestmap'
//grails.plugin.springsecurity.securityConfigType = 'Requestmap'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/presentation'   ,access: ['permitAll']],
	[pattern: '/presentation.gsp',access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]
