package by.it.academy.utils;

public class Constants {
    /**
     * USER
     */
    public static final String USER_ID = "userId";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String USER_ROLE = "userRole";
    /**
     * ENUMS
     */
    public static final String ROLES = "roles";
    public static final String PRIORITIES = "priorities";
    public static final String STATUSES = "statuses";
    /**
     * TASK
     */
    public static final String TASK_ID = "taskId";
    public static final String TASK = "task";
    public static final String TASK_DESCRIPTION = "task_description";
    public static final String ASSIGNEE = "user";
    public static final String TASK_USER = "taskUser";
    public static final String TASK_TEAM = "taskTeam";
    public static final String TEAM = "team";
    public static final String PRIORITY = "currentPriority";
    public static final String STATUS = "currentStatus";

    /**
     * TEAM
     */
    public static final String TEAM_ID = "teamId";
    public static final String NAME = "name";
    public static final String MEMBER = "member";
    public static final String MEMBERS = "members";
    public static final String TEAM_TASKS = "teamTasks";
    /**
     * URL
     */
    public static final String USERS_CREATE = "/users/create";
    public static final String USERS_READ = "/users/read";
    public static final String USERS_UPDATE = "/users/update";
    public static final String USERS_DELETE = "/users/delete";

    public static final String TEAMS_CREATE = "/teams/create";
    public static final String TEAMS_READ = "/teams/read";
    public static final String TEAMS_UPDATE = "/teams/update";
    public static final String TEAMS_DELETE = "/teams/delete";

    public static final String TASKS_CREATE = "/tasks/create";
    public static final String TASKS_READ = "/tasks/read";
    public static final String TASKS_UPDATE = "/tasks/update";
    public static final String TASKS_DELETE = "/tasks/delete";

    public static final String MENU = "/menu";
    /**
     * MAPPING
     */
    public static final String CREATE_USERS_JSP = "/pages/users/createUser.jsp";
    public static final String READ_USERS_JSP = "/pages/users/readUsers.jsp";
    public static final String UPDATE_USER_JSP = "/pages/users/updateUser.jsp";

    public static final String CREATE_TEAM_JSP = "/pages/teams/createTeams.jsp";
    public static final String READ_TEAM_JSP = "/pages/teams/readTeams.jsp";
    public static final String UPDATE_TEAM_JSP = "/pages/teams/updateTeam.jsp";

    public static final String CREATE_TASK_JSP = "/pages/tasks/createTask.jsp";
    public static final String UPDATE_TASK_JSP = "/pages/tasks/updateTask.jsp";
    public static final String READ_TASKS_JSP = "/pages/tasks/readTasks.jsp";

    public static final String REGISTRATION_ERROR = "/pages/errors/registrationError.jsp";

    public static final String MENU_JSP = "/pages/menu.jsp";
    /**
     * REPOSITORY
     */
    public static final String USERS = "users";
    public static final String TASKS = "tasks";
    public static final String TEAMS = "teams";
}