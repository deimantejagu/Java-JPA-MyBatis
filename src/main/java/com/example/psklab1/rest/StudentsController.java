package com.example.psklab1.rest;

import com.example.psklab1.entities.StudentGroup;
import com.example.psklab1.persistence.StudentGroupsDAO;
import com.example.psklab1.rest.contracts.StudentGroupDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Setter
@Getter
@ApplicationScoped
@Path("/group")
public class StudentsController {

    @Inject
    private StudentGroupsDAO studentGroupsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        StudentGroup studentGroup = studentGroupsDAO.findOne(id);

        StudentGroupDto studentGroupDto = new StudentGroupDto();
        studentGroupDto.setSpecialty(studentGroup.getSpecialty());
        studentGroupDto.setCourse(studentGroup.getCourse());

        return Response.ok(studentGroupDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudentGroup(StudentGroupDto studentGroupDto){
        try {
            StudentGroup studentGroup = new StudentGroup();
            studentGroup.setSpecialty(studentGroupDto.getSpecialty());
            studentGroup.setCourse(studentGroupDto.getCourse());

            studentGroupsDAO.persist(studentGroup);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudentGroup(@PathParam("id") Long id, StudentGroupDto studentGroupDto) {
        StudentGroup studentGroup = studentGroupsDAO.findOne(id);
        if (studentGroup == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        try {
            studentGroup.setSpecialty(studentGroupDto.getSpecialty());
            studentGroup.setCourse(studentGroupDto.getCourse());
            studentGroupsDAO.update(studentGroup);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
