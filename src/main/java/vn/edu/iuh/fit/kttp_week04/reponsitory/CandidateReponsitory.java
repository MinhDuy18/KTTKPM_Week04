package vn.edu.iuh.fit.kttp_week04.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.kttp_week04.entites.Candidate;

import java.util.List;

@Repository
public interface CandidateReponsitory extends JpaRepository<Candidate, Long> {
}

//@Repository
//public interface CandidateReponsitoty extends JpaRepository<Candidate, Long> {
//    List<Candidate> findByEmailNotNull();
//    @Query("SELECT distinct e.candidate FROM Experience e WHERE e.roles = ?1")
//    List<Candidate> findCandidatesByExperienceRole(Role roles);
//
//
//}
