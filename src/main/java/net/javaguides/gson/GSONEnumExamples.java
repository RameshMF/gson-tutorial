package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class GSONEnumExamples {
	public static void main(String[] args) {
		serializeEnumGson();
		deserializeEnumGson();
	}

	public static void serializeEnumGson() {
		Project project = new Project(100, "CMS", "Content Management System", ProjectStatus.NEW);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String result = gson.toJson(project);
		System.out.println(result);
	}

	public static void deserializeEnumGson() {
		String input = "{\r\n" + "  \"projectId\": 100,\r\n" + "  \"projectName\": \"CMS\",\r\n"
				+ "  \"projectDesc\": \"Content Management System\",\r\n" + "  \"projectStatus\": \"1\"\r\n" + "}";
		Gson gson = new GsonBuilder().create();
		Project project = gson.fromJson(input, Project.class);
		System.out.println(project.toString());
	}
}

enum ProjectStatus {
	@SerializedName("1")
	NEW, @SerializedName("2")
	OPEN, @SerializedName("3")
	PROGRESS, @SerializedName("4")
	HOLD, @SerializedName("5")
	COMPLETED, @SerializedName("6")
	CLOSED
}

class Project {
	private int projectId;
	private String projectName;
	private String projectDesc;
	private ProjectStatus projectStatus;

	public Project(int projectId, String projectName, String projectDesc, ProjectStatus projectStatus) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectStatus = projectStatus;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDesc=" + projectDesc
				+ ", projectStatus=" + projectStatus + "]";
	}
}