package dev.team4.controller;


import dev.team4.models.Ticket;
import dev.team4.services.TicketService;
import io.javalin.http.Context;

import java.util.List;


public class TicketController {
    private static TicketService ts;

    public TicketController(TicketService ts) {
        this.ts = ts;
    }

    // select all Ticket
    public void selectAllTicket(Context ctx) {
        ctx.status(200);
        List<Ticket> tickets = ts.selectAllTicket();
        ctx.json(tickets);
    }

    public void buyTicket(Context ctx) {
        Ticket t = ctx.bodyAsClass(Ticket.class);

        System.out.println(" " + ctx.sessionAttribute("id"));

        t.setCustomer_id(ctx.sessionAttribute("id"));

        System.out.println(" " + t.getCustomer_id());

        boolean success = ts.buyTicket(t);
        try {

            if (!success) {
                ctx.status(404);
            } else {
                ctx.status(200);
                ctx.json(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getAllCustomersTickets(Context ctx) {
        List<Ticket> result = ts.getAllCustomersTickets(ctx.sessionAttribute("id") == null ? 0 : ctx.sessionAttribute("id"));

        if (result != null) {
            ctx.status(200);
            ctx.json(result);
        } else {
            ctx.status(404);
        }
    }

    public void deleteTicket(Context ctx) {
        Ticket t = ctx.bodyAsClass(Ticket.class);

        int id = t.getId();

        System.out.println(id);

        //int customerid = t.getCustomer_id();

        boolean success = ts.deleteTicket(id);

        Ticket tickets = null;

        try {

            if (success) {
                System.out.println("sending 200 status" + id);
                ctx.status(200);
                ctx.json(t);
            } else {
                System.out.println("sending 404 error" + id);
                ctx.status(404);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
