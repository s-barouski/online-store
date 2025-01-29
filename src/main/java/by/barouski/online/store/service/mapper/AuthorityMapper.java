package by.barouski.online.store.service.mapper;

import by.barouski.online.store.entity.Authority;
import by.barouski.online.store.service.dto.AuthorityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    List<Authority> authorityDtosToAuthoritys(List<AuthorityDto> authorityDtos);
    Authority authorityDtoToAuthority(AuthorityDto authorityDto);

    List<AuthorityDto> authoritysToAuthorityDtos(List<Authority> authorities);
    AuthorityDto authorityToAuthorityDto (Authority authority);
}
