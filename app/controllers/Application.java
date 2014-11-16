package controllers;

import java.util.List;
import java.util.Random;

import models.Event;
import models.Institution;
import models.Org;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	
	public static int generateId() {
		Random rand = new Random();
    	return rand.nextInt(400000090) + 1;
	}
    
    public static Result createTestData() {
    	// please forgive us, code-gods
    	List<Org> orgs = Org.find.all();
    	if (!orgs.isEmpty()) {
    		// If test-data was generated, no need to regenerate.
    		return ok(views.html.testdata.render(orgs, Institution.find.all(), Event.find.all()));
    	}	
    	
    	// oh god this is so hacky
    	// You will have a mess-load of terrible test data, but it'll exist at least!    	
    	Institution inst1 = new Institution();
    	int id = generateId();
    	inst1.setId(id);
    	inst1.setName("Dartmouth College");
    	inst1.setLocation("Hanover, New Hampshire");
    	inst1.setContact("Contact: Philip J. Hanlon, President");
    	inst1.setUrl("www.dartmouth.edu/");
    	Institution.createInstitution(inst1);
    	
    	Institution inst2 = new Institution();
    	id = generateId();
    	inst2.setId(id);
    	inst2.setName("Hampshire College");
    	inst2.setLocation("Hanover, New Hampshire");
    	inst2.setContact("Contact: Philip J. Hanlon, President");
    	inst2.setUrl("www.dartmouth.edu/");
    	Institution.createInstitution(inst2);
    	
    	Institution inst3 = new Institution();
    	id = generateId();
    	inst3.setId(id);
    	inst3.setName("Boston University");
    	inst3.setLocation("Boston, Massachusetts");
    	inst3.setContact("Contact: Noah K., ~Alumnus~");
    	inst3.setUrl("www.bu.edu");
    	Institution.createInstitution(inst3);
    	
    	/*
    	 * Orgs
    	 */
    	// Hampshire
    	Org org1 = new Org();
    	id = generateId();
    	org1.setId(id);
    	org1.setName("Gender Identity Resource Network");
    	org1.setContact("Contact: shg13@hampshire.edu");
    	org1.setSummary("The mission of the Gender-Identity Resource Network (Grin) is to provide resources related to gender identity for members of the Hampshire community. We sponsor events and programming based on the needs and desires of gender diverse students and create spaces for them to feel comfortable, have fun, learn, and get support. We accomplish this through events and programming which we sponsor, such as a biweekly drop-in spaces to socialize, workshops and skill-shares, a free clothing box for people transitioning their wardrobes and experimenting with gender expression; screening media that relates to issues of gender identity, and maintaining a Hampedia page with links to online resources and resources in the Valley.");
    	org1.setInstitutionId(inst2.getId());
    	Org.createOrg(org1);
    	
    	Org org2 = new Org();
    	id = generateId();
    	org2.setId(id);
    	org2.setName("QIPOC");
    	org2.setContact("Contact: sas12@hampshire.edu");
    	org2.setSummary("QIPOC is a closed group for self-identified queer people of color and international students in and around the Hampshire College community. QIPOC's work is a combination of community building and activism. We strive to create safe(r), accountable, and fully intentional spaces that value and honor our histories/herstories and our lived experiences as queer people and people of color. We reject the notions of choosing between those identities or placing one above the other.");
    	org2.setInstitutionId(inst2.getId());
    	Org.createOrg(org2);
    	
    	Org org3 = new Org();
    	id = generateId();
    	org3.setId(id);
    	org3.setName("Queer Community Alliance (QCA)");
    	org3.setContact("Contact: erSA@hampshire.edu");
    	org3.setSummary("The Hampshire College Queer Community Alliance (QCA) has two main functions. First, it acts as an umbrella for other related groups on campus, such as TSA, Aliz, and QIPOC. In this capacity, it offers meeting and event space, supports queer, trans, and gender nonconforming identities and an array of other related programming. Additionally, it operates a listerve to publicize events and current updates. Second, the QCA strives to bring the queer, trans, gender-variant, and ally communities and student populations together through meetings, as well as social and educational events. Every day students with non-traditional sexual preferences and gender identities face homophobia, heterosexism and gender policing both overtly and subtly on and off campus. By offering safe spaces, opportunities to socialize and education programming, the QCA aims to help queer and gender-variant students by fostering a sense of community, safety and pride.");
    	org3.setInstitutionId(inst2.getId());
    	Org.createOrg(org3);
    	
    	// Dartmouth
    	Org org4 = new Org();
    	id = generateId();
    	org4.setId(id);
    	org4.setName("Dartmouth Action Collective");
    	org4.setContact("Contact: The Dartmouth Radical");
    	org4.setSummary("The only progressive newspaper at Dartmouth!");
    	org4.setInstitutionId(inst1.getId());
    	Org.createOrg(org4);
    	
    	/**
    	 * Events!
    	 */ 	
    	
    	// Hampshire
    	Event event = new Event();
    	id = generateId();
    	event.setId(id);
    	event.setName("Trans Day of Remembrance 2014");
    	event.setLocation("Hampshire College");
    	event.setSummary("The Transgender Day of Remembrance was started by Gwendolyn Ann Smith to memorialize those who were killed due to anti-transgender hatred or prejudice. The event is held in November to honor Rita Hester, whose murder on November 28th, 1998 kicked off the “Remembering Our Dead” web project and a San Francisco candlelight vigil in 1999. Rita Hester’s murder — like most anti-transgender murder cases — has yet to be solved. Although not everyone we will be remembering necessarily self-identified as transgender, the violence against them was motivated by cissexism and transphobia. We will commemorate this day at Hampshire by writing in chalk all around campus the names of all the dead, as well as statistics about violence against trans and gender non-conformig people. We will also have a table set up outside the library to talk about the chalk around campus. We would also like to bring attention to those whose names we do not even know, their bodies unidentified or unidentifiable. This facebook event and the corresponding intranet post will be our trigger warning to the campus. Please invite as many members of the hampshire community as possible to this event so we can get out the word. For more information you can go to http://tdor.info/memorializing-2014-2/");
    	event.setEventDate("11/16/14");
    	event.setOrgId(org1.getId());
    	Event.createEvent(event);
    	
    	Event event3 = new Event();
    	id = generateId();
    	event3.setId(id);
    	event3.setName("Gender Zine Workshop with GRIN");
    	event3.setLocation("Center for Feminisms, Hampshire College");
    	event3.setSummary("Cissexist notions of gender are embedded in our society as assumed defaults, to the point that it's incredibly difficult to find the language to communicate experiences and feelings which fall outside of the expected norm. Such as what exactly gender dysphoria feels like for someone who experiences it , or what different pronouns feel like. or what exactly it means to you to be feminine, masculine, or something else. The difficult in sharing our stories and experiences only makes it harder for others to understand their own experiences (and knowing if you experience something can be pretty tough when nobody can tell you what it feels like). Zines are one fantastic way to express yourself and get across through written and visual art that which we can't explain in simple terms! Zines are also a great way to create the representation of various genders and ways having genders which are lacking in the mainstream media. Come learn how to make zines from Hampshire Community Member Nora Miller and Esteemed Zinester Constance Zaber; and make zines about whatever you want, such as gender and experiences of gender! We will provide paper, scissors, markers, writing utensils, and collaging materials; as well as some amount of funds for making copies. We would love it if you'd like to contribute a copy of your zine to the CFF and QCAC libraries! Also feel free to bring any of your own supplies! The Center For Feminisms is a sub-free space. This event is open to all people of all genders or lackthereof, including cis allies. We ask that you be respectful of others by not assuming anyone's identity or pronouns based on their appearance, and by not trying to police anybody else's identity. After the workshop, feel free to join us for an organizing meeting!");
    	event3.setEventDate("11/16/14");
    	event3.setOrgId(org1.getId());
    	Event.createEvent(event3);
    	
    	Event event4 = new Event();
    	id = generateId();
    	event4.setId(id);
    	event4.setName("We Out This B!%€H QTPOC Valley Meet up!");
    	event4.setLocation("Amherst, Massachusetts");
    	event4.setSummary("Cissexist notions of gender are embedded in our society as assumed defaults, to the point that it's incredibly difficult to find the language to communicate experiences and feelings which fall outside of the expected norm. Such as what exactly gender dysphoria feels like for someone who experiences it , or what different pronouns feel like. or what exactly it means to you to be feminine, masculine, or something else. The difficult in sharing our stories and experiences only makes it harder for others to understand their own experiences (and knowing if you experience something can be pretty tough when nobody can tell you what it feels like). Zines are one fantastic way to express yourself and get across through written and visual art that which we can't explain in simple terms! Zines are also a great way to create the representation of various genders and ways having genders which are lacking in the mainstream media. Come learn how to make zines from Hampshire Community Member Nora Miller and Esteemed Zinester Constance Zaber; and make zines about whatever you want, such as gender and experiences of gender! We will provide paper, scissors, markers, writing utensils, and collaging materials; as well as some amount of funds for making copies. We would love it if you'd like to contribute a copy of your zine to the CFF and QCAC libraries! Also feel free to bring any of your own supplies! The Center For Feminisms is a sub-free space. This event is open to all people of all genders or lackthereof, including cis allies. We ask that you be respectful of others by not assuming anyone's identity or pronouns based on their appearance, and by not trying to police anybody else's identity. After the workshop, feel free to join us for an organizing meeting!");
    	event4.setEventDate("Monday, May 5 at 7:00pm");
    	event4.setOrgId(org2.getId());
    	Event.createEvent(event4);
    	
    	// Dartmouth
    	Event event2 = new Event();
    	id = generateId();
    	event2.setId(id);
    	event2.setName("President's Office Sit In");
    	event2.setLocation("Dartmouth College President’s Office");
    	event2.setSummary("A super cool hackathon!");
    	event2.setEventDate("April 9th, 2014");
    	event2.setOrgId(org4.getId());
    	Event.createEvent(event2);
    	
    	return ok(views.html.testdata.render(Org.find.all(), Institution.find.all(), Event.find.all()));
    }

}
