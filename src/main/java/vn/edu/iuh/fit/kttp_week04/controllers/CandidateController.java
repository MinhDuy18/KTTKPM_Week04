package vn.edu.iuh.fit.kttp_week04.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.kttp_week04.entites.Candidate;
import vn.edu.iuh.fit.kttp_week04.reponsitory.CandidateReponsitory;

import java.util.List;

//@Controller
@RestController
public class CandidateController {
    @Autowired
    private  CandidateReponsitory candidateReponsitory;
    @GetMapping("/index")
    public   String  showIndex(Model model){
        return "Candidate/index";
    }
    @GetMapping("/candidates")
    public String  showCandidate(Model model){
        model.addAttribute("candidatePage",candidateReponsitory.findAll());
       return "Candidate/ListCandidate";
    }

    @GetMapping("/candidates/{id}")
    public String showCandidateDetails(@PathVariable("id") Long id, Model model) {
        Candidate candidate = candidateReponsitory.findById(id).orElse(null);
        if (candidate != null)
            model.addAttribute("candidateDetail", candidate);
        return candidate+""; // Trả về view để hiển thị chi tiết candidate

    }
    @GetMapping("/cadidates/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id){
        Candidate candidate = candidateReponsitory.findById(id).orElse(null);

        candidateReponsitory.delete(candidate);
        return "redirect:/candidates";

    }

    //    //show form add
//    @GetMapping ("/customers/show-add-form")
//    public String addCustomer(Model model) {
//        Customer customer = new Customer();
//        model.addAttribute("customerAdd",customer);
//        return "customer/add";
//    }
    @GetMapping("/candidates/showformadd")
    public String add(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candidateAdd",candidate);
        return "Candidate/addCandidateForm";
    }
    @PostMapping("/cadidates/add")
    public String addCandidate(@ModelAttribute Candidate candidate){
        candidateReponsitory.save(candidate);
        return "redirect:/candidates";
    }

//    @GetMapping("/candidates/update/{id}")
//    public String update(@PathVariable("id") long id, Model model) {
//        Candidate candidate = candidateRepository.findById(id).orElse(null);
//        if (candidate != null)
//            model.addAttribute("candidateUpdate", candidate);
//        return "Candidate/updateForm"; // Trả về view để hiển thị chi tiết candidate
//
//    }
//
//    @PostMapping("/cadidates/update/{id}")
//    public String uppdateCandidate(@PathVariable("id") long id,@ModelAttribute("candidateUpdate") Candidate candidateUpdate){
//        Candidate candidate = candidateRepository.findById(id).orElse(null);
//        if(candidate != null){
//            candidate.setFullName(candidateUpdate.getFullName());
//            candidate.setEmail(candidateUpdate.getEmail());
//            candidate.setPhone(candidateUpdate.getPhone());
//            candidate.setId(candidateUpdate.getId());
//            candidateRepository.save(candidate);
//        }
//        return "redirect:/candidates";
//    }
}
